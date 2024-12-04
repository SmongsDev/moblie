package kr.or.changwon.changchang.changchang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.changwon.changchang.changchang.entity.Title;
import kr.or.changwon.changchang.changchang.repository.TitleRepository;

@SpringBootTest
public class TitleTest {

    @Autowired
    private TitleRepository titleRepository;

    @Test
    public void createInitialTitles() {
        Title title1 = new Title();
        title1.setName("창대생");
        title1.setDescription("창원대학교 학생");
        title1.setRarity("일반");
        title1.setConditions("기본 칭호");


        Title title3 = new Title();
        title3.setName("과대");
        title3.setDescription("학과 내 학생회장을 맡고 있는 학생. 학과의 대표 역할을 하며 다양한 행사와 활동을 주도하는 리더.");
        title3.setRarity("레어");
        title3.setConditions("학과 학생회장직을 맡은 학생");

        Title title4 = new Title();
        title4.setName("휴학생");
        title4.setDescription("학업을 일시적으로 중단한 학생. 개인적인 사유나 기타 이유로 휴학을 한 상태.");
        title4.setRarity("일반");
        title4.setConditions("현재 휴학 중인 학생");

        Title title5 = new Title();
        title5.setName("학회장");
        title5.setDescription("학과 내 또는 학교의 동아리, 학회를 이끄는 대표. 활동을 조직하고 회원들을 관리하는 리더 역할을 한다.");
        title5.setRarity("영웅");
        title5.setConditions("동아리나 학회의 회장직을 맡은 학생");

        Title title6 = new Title();
        title6.setName("졸업생");
        title6.setDescription("대학을 졸업한 학생. 모든 학점을 이수하고 학위를 취득한 졸업생에게 부여되는 칭호.");
        title6.setRarity("레어");
        title6.setConditions("학위를 취득하고 졸업한 학생");

        Title title7 = new Title();
        title7.setName("부학회장");
        title7.setDescription("학회에서 회장의 바로 밑에서 지원하고 활동을 보조하는 부회장. 다양한 학회 활동을 책임지고 조직한다.");
        title7.setRarity("영웅");
        title7.setConditions("학회의 부회장직을 맡은 학생");

        Title title8 = new Title();
        title8.setName("비둘기");
        title8.setDescription("학생들 사이에서 종종 캠퍼스에서 자주 보이는 인물. 수업이나 활동에 자주 등장하지만 별다른 참여나 관심을 보이지 않는 학생.");
        title8.setRarity("히든");
        title8.setConditions("개인주의 학생");
        
        Title title9 = new Title();
        title9.setName("동아리 회장");
        title9.setDescription("동아리 내에서 가장 높은 직책을 맡고 있는 학생. 동아리의 전반적인 활동을 이끌고 조직하는 리더 역할을 한다.");
        title9.setRarity("희귀");
        title9.setConditions("동아리의 회장직을 맡은 학생");
                
        Title title10 = new Title();
        title10.setName("CASPER 회장");
        title10.setDescription("모든 동아리를 압도하는 CASPER 내에서 가장 높은 직책을 맡고 있는 학생. 창원대의 얼굴이 보통 해당 역할을 부여받는다.");
        title10.setRarity("희든");
        title10.setConditions("CASPER 동아리의 회장직을 맡은 학생");

        Title title11 = new Title();
        title11.setName("복학생");
        title11.setDescription("대학 생활을 재개한 학생");
        title11.setRarity("일반");
        title11.setConditions("최소 1학기 이상 휴학 후 복학한 학생");

        Title title12 = new Title();
        title12.setName("과탑");
        title12.setDescription("자신의 학과에서 학업 성적이 가장 뛰어난 학생. 과내에서 최고 성적을 기록한 자에게 부여되는 칭호.");
        title12.setRarity("영웅");
        title12.setConditions("학과에서 가장 높은 GPA를 보유한 학생");

        Title title13 = new Title();
        title13.setName("컴공 1과대");
        title13.setDescription("모든 업적을 달성한 전설적인 존재");
        title13.setRarity("희귀");
        title13.setConditions("4과대의 지지를 받는 자");
        
        Title title2 = new Title();
        title2.setName("컴공 2과대");
        title2.setDescription("모든 업적을 달성한 전설적인 존재");
        title2.setRarity("희귀");
        title2.setConditions("4과대의 지지를 받는 자");

        Title title14 = new Title();
        title14.setName("컴공 3과대");
        title14.setDescription("모든 업적을 달성한 전설적인 존재");
        title14.setRarity("희귀");
        title14.setConditions("4과대의 지지를 받는 자");

        Title title15 = new Title();
        title15.setName("컴공 4과대");
        title15.setDescription("모든 업적을 달성한 전설적인 존재");
        title15.setRarity("희귀");
        title15.setConditions("4과대의 지지를 받는 자");

        titleRepository.save(title1);
        titleRepository.save(title3);
        titleRepository.save(title4);
        titleRepository.save(title5);
        titleRepository.save(title6);
        titleRepository.save(title7);
        titleRepository.save(title8);
        titleRepository.save(title9);
        titleRepository.save(title10);
        titleRepository.save(title11);
        titleRepository.save(title12);
        titleRepository.save(title13);
        titleRepository.save(title2);
        titleRepository.save(title14);
        titleRepository.save(title15);
    }

    @Test
    public void addTitles(){
    }
}
    