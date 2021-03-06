package site.metacoding.weathertest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String MSRDT; // 측정일시
    private String MSRRGN_NM; // 권역명
    private String MSRSTE_NM; // 측정소명
    private String PM10; // 미세먼지
    private String PM25; // 초미세먼지농도
    private String O3; // 오존
    private String NO2; // 이산화질소농도
    private String CO; // 일산화탄소농도
    private String SO2; // 아황산가스농도
    private String IDEX_NM; // 통합대기환경등급
    private String IDEX_MVL; // 통합대기환경지수
    private String ARPLT_MAIN; // 지수결정물질
}
