package kr.or.changwon.changchang.changchang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.or.changwon.changchang.changchang.entity.Notice;
import kr.or.changwon.changchang.changchang.service.NoticeService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
public class CrawlController {

	@Autowired
	private NoticeService noticeService;

	// 크롤링을 진행하고 DB에 저장하는 엔드포인트
	@GetMapping("/crawl")
	public Map<String, String> crawl() {
		Map<String, String> response = new HashMap<>();
		try {
			noticeService.crawlAndSaveNotices();
			response.put("status", "success");
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", e.getMessage());
		}
		return response;
	}

	// 모든 공지사항을 가져오는 엔드포인트
	@GetMapping("/notices")
	public List<Notice> getAllNotices() {
		return noticeService.getAllNotices();
	}

	// 학과별 공지사항을 가져오는 엔드포인트
	@GetMapping("/notices/department/{departmentId}")
	public List<Notice> getNoticesByDepartmentId(@PathVariable Long departmentId) {
		return noticeService.getNoticesByDepartmentId(departmentId);
	}
}