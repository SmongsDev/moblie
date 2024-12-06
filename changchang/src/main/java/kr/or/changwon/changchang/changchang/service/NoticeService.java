package kr.or.changwon.changchang.changchang.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import kr.or.changwon.changchang.changchang.entity.Department;
import kr.or.changwon.changchang.changchang.entity.Notice;
import kr.or.changwon.changchang.changchang.repository.DepartmentRepository;
import kr.or.changwon.changchang.changchang.repository.NoticeRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class NoticeService {

	private final NoticeRepository noticeRepository;
	private final DepartmentRepository departmentRepository;

	public NoticeService(NoticeRepository noticeRepository, DepartmentRepository departmentRepository) {
		this.noticeRepository = noticeRepository;
		this.departmentRepository = departmentRepository;
	}

	@Scheduled(cron = "0 0 0 * * ?") // 매일 자정 기준
	public void scheduledCrawlAndSaveNotices() {
		crawlAndSaveNotices();
	}

	public void crawlAndSaveNotices() {
		List<Department> departments = departmentRepository.findAll();
		noticeRepository.deleteAll(); // 기존 공지사항 삭제
		for (Department department : departments) {
			try {
				// URL 형식 검증
				new URL(department.getCrawlUrl());
				// Jsoup을 사용하여 HTML 문서 가져오기
				Document doc = Jsoup.connect(department.getCrawlUrl()).get();
				// 클래스가 "BD_list"인 요소 선택
				Elements listBoxElements = doc.getElementsByClass("BD_list");
				for (Element listBoxElement : listBoxElements) {
					// 클래스가 "ta_l bbs_tit"인 요소 선택
					Elements titElements = listBoxElement.getElementsByClass("ta_l bbs_tit");
					for (Element titElement : titElements) {
						// 제목과 data-id 속성 추출
						String title = titElement.text();
						String dataId = titElement.select("a").attr("data-id");
						if (dataId != null && !dataId.isEmpty()) {
							// 링크 생성
							String link = department.getLinkPattern() + dataId;
							// 공지 여부 확인
							Element previousTd = titElement.previousElementSibling();
							Element firstTd = previousTd.select("td").first();
							String type = firstTd != null && firstTd.select("b.btn_S.btn_red.BD_tm_none").size() > 0
									? "공지"
									: "일반";
							saveNotice(title, link, type, department);
						}
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveNotice(String title, String link, String type, Department department) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setLink(link);
		notice.setType(type);
		notice.setDepartment(department);
		noticeRepository.save(notice);
	}

	public List<Notice> getAllNotices() {
		return noticeRepository.findAll();
	}

	public List<Notice> getNoticesByDepartmentId(Long departmentId) {
		return noticeRepository.findByDepartmentId(departmentId);
	}
}