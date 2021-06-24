package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@AllArgsConstructor
public class STSSORD15100T01 {
    //String rec_cnt; // 반복수
    int page;
    int page_size;
    @NotEmpty(message = "please provide a search_cl_cd")
    String search_cl_cd; // 조회기준
    String strd_dt_from; // 기준일자시작일
    String strd_dt_to; // 기준일자동료일
    String sale_org_id; // 소속영업조직ID
    String cust_typ_stc_cd; // 고객유형통계코드
    String svc_gr_cl_cd; // 서비스등급통계코드
    String eqp_typ_stc_cd; // 단말기유형통계코드
    String mfact_cd; // 제조사코드
    String eqp_mdl_cd1; //단말기모델코드1
    String br_sel_cl_cd; // 영업장구분
    String post_op_br_cl_cd; //소속처리영업장구분코드
    String iphone_id; // iphone
    String psnm_yn; // PSNM
    String eqp_mdl_cd_ctt; //단말기모델코드 목록
    String rep_eqp_yn; // 대표단말기여부
}
