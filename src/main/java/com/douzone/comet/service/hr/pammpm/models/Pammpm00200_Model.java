package com.douzone.comet.service.hr.pammpm.models;
 
import java.math.BigDecimal;

import com.douzone.gpd.jdbc.mybatis.model.DzAbstractModel;
import com.douzone.gpd.restful.annotation.DzModel;
import com.douzone.gpd.restful.annotation.DzModelField;
import com.google.gson.annotations.SerializedName;
 
@DzModel(name = "PAMMPM00200_MODEL", desc = "사업장,대상자정보등록리스트", tableName = "")
public class Pammpm00200_Model extends DzAbstractModel {

	@SerializedName("_uid")
	@DzModelField(name="_uid",desc="_uid",colName="_uid")
	private String _uid;
	
	@SerializedName("COMPANY_CD")
	@DzModelField(name="company_cd", desc="회사코드", colName="COMPANY_CD", colSize="7", isKey=false)
	private String company_cd;
	  
	@SerializedName("EMP_NO")
	@DzModelField(name="emp_no", desc="사원번호", colName="EMP_NO", colSize="20", isKey=false)
	private String emp_no;
	  
	@SerializedName("DOC_NO")
	@DzModelField(name="doc_no", desc="문서번호", colName="DOC_NO", colSize="20", isKey=false)
	private String doc_no;
	  
	@SerializedName("WRT_DT")
	@DzModelField(name="wrt_dt", desc="작성일", colName="WRT_DT", colSize="8", isKey=false)
	private String wrt_dt;
	  
	@SerializedName("CLOSE_YN")
	@DzModelField(name="close_yn", desc="마감여부", colName="CLOSE_YN", colSize="1", isKey=false)
	private String close_yn;
	  
	@SerializedName("REQ_KND_FG")
	@DzModelField(name="req_knd_fg", desc="신청종류구분", colName="REQ_KND_FG", colSize="5", isKey=false)
	private String req_knd_fg;
	  
	@SerializedName("KOR_NM")
	@DzModelField(name="kor_nm", desc="한글명", colName="KOR_NM", colSize="50", isKey=false)
	private String kor_nm;
	  
	@SerializedName("BIZAREA_MNG_NO")
	@DzModelField(name="bizarea_mng_no", desc="사업장관리번호", colName="BIZAREA_MNG_NO", colSize="20", isKey=false)
	private String bizarea_mng_no;
	  
	@SerializedName("BIZAREA_NM")
	@DzModelField(name="bizarea_nm", desc="사업장명", colName="BIZAREA_NM", colSize="50", isKey=false)
	private String bizarea_nm;
	  
	@SerializedName("POST_NO")
	@DzModelField(name="post_no", desc="우편번호", colName="POST_NO", colSize="20", isKey=false)
	private String post_no;
	  
	@SerializedName("ADDR_TP")
	@DzModelField(name="addr_tp", desc="주소유형", colName="ADDR_TP", colSize="3", isKey=false)
	private String addr_tp;
	  
	@SerializedName("BASE_ADDR")
	@DzModelField(name="base_addr", desc="기본주소", colName="BASE_ADDR", colSize="100", isKey=false)
	private String base_addr;
	  
	@SerializedName("DTL_ADDR")
	@DzModelField(name="dtl_addr", desc="상세주소", colName="DTL_ADDR", colSize="100", isKey=false)
	private String dtl_addr;
	  
	@SerializedName("PSPTCOM_YN")
	@DzModelField(name="psptcom_yn", desc="우선지원대상기업여부", colName="PSPTCOM_YN", colSize="1", isKey=false)
	private String psptcom_yn;
	  
	@SerializedName("RSPT_EMP_NO")
	@DzModelField(name="rspt_emp_no", desc="담당사원번호", colName="RSPT_EMP_NO", colSize="20", isKey=false)
	private String rspt_emp_no;
	  
	@SerializedName("RSPT_TEL_NO")
	@DzModelField(name="rspt_tel_no", desc="담당전화번호", colName="RSPT_TEL_NO", colSize="20", isKey=false)
	private String rspt_tel_no;
	  
	@SerializedName("RSPT_EMAIL_NM")
	@DzModelField(name="rspt_email_nm", desc="담당이메일명", colName="RSPT_EMAIL_NM", colSize="50", isKey=false)
	private String rspt_email_nm;
	  
	@SerializedName("TRGTP_RES_NO")
	@DzModelField(name="trgtp_res_no", desc="대상자주민등록번호", colName="TRGTP_RES_NO", colSize="32", isKey=false)
	private String trgtp_res_no;
	  
	@SerializedName("CHLDBRTH_DT")
	@DzModelField(name="chldbrth_dt", desc="출산일", colName="CHLDBRTH_DT", colSize="8", isKey=false)
	private String chldbrth_dt;
	  
	@SerializedName("DIVD_YN")
	@DzModelField(name="divd_yn", desc="분할여부", colName="DIVD_YN", colSize="1", isKey=false)
	private String divd_yn;
	  
	@SerializedName("TERM_CD")
	@DzModelField(name="term_cd", desc="기간코드", colName="TERM_CD", colSize="5", isKey=false)
	private String term_cd;
	  
	@SerializedName("MLTPPRGN_YN")
	@DzModelField(name="mltpprgn_yn", desc="다태아여부", colName="MLTPPRGN_YN", colSize="1", isKey=false)
	private String mltpprgn_yn;
	  
	@SerializedName("USL_WAGE_CD")
	@DzModelField(name="usl_wage_cd", desc="통상임금코드", colName="USL_WAGE_CD", colSize="5", isKey=false)
	private String usl_wage_cd;
	  
	@SerializedName("USL_WAGE_AMT")
	@DzModelField(name="usl_wage_amt", desc="통상임금금액", colName="USL_WAGE_AMT", colSize="19", isKey=false)
	private BigDecimal usl_wage_amt;
	  
	@SerializedName("MM_FIXED_LABORTM_DY")
	@DzModelField(name="mm_fixed_labortm_dy", desc="월소정근로시간일수", colName="MM_FIXED_LABORTM_DY", colSize="7", isKey=false)
	private BigDecimal mm_fixed_labortm_dy;

    @SerializedName("BIZAREA_CD")
	@DzModelField(name="bizarea_cd", desc="사업장코드", colName="BIZAREA_CD", colSize="7", isKey=false)
	private BigDecimal bizarea_cd;
    
 
	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String getCompany_cd() {
		return company_cd;
	}

	public void setCompany_cd(String company_cd) {
		this.company_cd = company_cd;
	}
 
	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
 
	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}
 
	public String getWrt_dt() {
		return wrt_dt;
	}

	public void setWrt_dt(String wrt_dt) {
		this.wrt_dt = wrt_dt;
	}
 
	public String getClose_yn() {
		return close_yn;
	}

	public void setClose_yn(String close_yn) {
		this.close_yn = close_yn;
	}
 
	public String getReq_knd_fg() {
		return req_knd_fg;
	}

	public void setReq_knd_fg(String req_knd_fg) {
		this.req_knd_fg = req_knd_fg;
	}
 
	public String getKor_nm() {
		return kor_nm;
	}

	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
 
	public String getBizarea_mng_no() {
		return bizarea_mng_no;
	}

	public void setBizarea_mng_no(String bizarea_mng_no) {
		this.bizarea_mng_no = bizarea_mng_no;
	}
 
	public String getBizarea_nm() {
		return bizarea_nm;
	}

	public void setBizarea_nm(String bizarea_nm) {
		this.bizarea_nm = bizarea_nm;
	}
 
	public String getPost_no() {
		return post_no;
	}

	public void setPost_no(String post_no) {
		this.post_no = post_no;
	}
 
	public String getAddr_tp() {
		return addr_tp;
	}

	public void setAddr_tp(String addr_tp) {
		this.addr_tp = addr_tp;
	}
 
	public String getBase_addr() {
		return base_addr;
	}

	public void setBase_addr(String base_addr) {
		this.base_addr = base_addr;
	}
 
	public String getDtl_addr() {
		return dtl_addr;
	}

	public void setDtl_addr(String dtl_addr) {
		this.dtl_addr = dtl_addr;
	}
 
	public String getPsptcom_yn() {
		return psptcom_yn;
	}

	public void setPsptcom_yn(String psptcom_yn) {
		this.psptcom_yn = psptcom_yn;
	}
 
	public String getRspt_emp_no() {
		return rspt_emp_no;
	}

	public void setRspt_emp_no(String rspt_emp_no) {
		this.rspt_emp_no = rspt_emp_no;
	}
 
	public String getRspt_tel_no() {
		return rspt_tel_no;
	}

	public void setRspt_tel_no(String rspt_tel_no) {
		this.rspt_tel_no = rspt_tel_no;
	}
 
	public String getRspt_email_nm() {
		return rspt_email_nm;
	}

	public void setRspt_email_nm(String rspt_email_nm) {
		this.rspt_email_nm = rspt_email_nm;
	}
 
	public String getTrgtp_res_no() {
		return trgtp_res_no;
	}

	public void setTrgtp_res_no(String trgtp_res_no) {
		this.trgtp_res_no = trgtp_res_no;
	}
 
	public String getChldbrth_dt() {
		return chldbrth_dt;
	}

	public void setChldbrth_dt(String chldbrth_dt) {
		this.chldbrth_dt = chldbrth_dt;
	}
 
	public String getDivd_yn() {
		return divd_yn;
	}

	public void setDivd_yn(String divd_yn) {
		this.divd_yn = divd_yn;
	}
 
	public String getTerm_cd() {
		return term_cd;
	}

	public void setTerm_cd(String term_cd) {
		this.term_cd = term_cd;
	}
 
	public String getMltpprgn_yn() {
		return mltpprgn_yn;
	}

	public void setMltpprgn_yn(String mltpprgn_yn) {
		this.mltpprgn_yn = mltpprgn_yn;
	}
 
	public String getUsl_wage_cd() {
		return usl_wage_cd;
	}

	public void setUsl_wage_cd(String usl_wage_cd) {
		this.usl_wage_cd = usl_wage_cd;
	}
 
	public BigDecimal getUsl_wage_amt() {
		return usl_wage_amt;
	}

	public void setUsl_wage_amt(BigDecimal usl_wage_amt) {
		this.usl_wage_amt = usl_wage_amt;
	}
 
	public BigDecimal getMm_fixed_labortm_dy() {
		return mm_fixed_labortm_dy;
	}

	public void setMm_fixed_labortm_dy(BigDecimal mm_fixed_labortm_dy) {
		this.mm_fixed_labortm_dy = mm_fixed_labortm_dy;
	}
	
    public BigDecimal getBizarea_cd() {
		return bizarea_cd;
	}

	public void setBizarea_cd(BigDecimal bizarea_cd) {
		this.bizarea_cd = bizarea_cd;
	}

	@Override
	public String toString() {
		return "Pammpm00200_Model [_uid=" + _uid + ", company_cd=" + company_cd + ", emp_no=" + emp_no + ", doc_no="
				+ doc_no + ", wrt_dt=" + wrt_dt + ", close_yn=" + close_yn + ", req_knd_fg=" + req_knd_fg + ", kor_nm="
				+ kor_nm + ", bizarea_mng_no=" + bizarea_mng_no + ", bizarea_nm=" + bizarea_nm + ", post_no=" + post_no
				+ ", addr_tp=" + addr_tp + ", base_addr=" + base_addr + ", dtl_addr=" + dtl_addr + ", psptcom_yn="
				+ psptcom_yn + ", rspt_emp_no=" + rspt_emp_no + ", rspt_tel_no=" + rspt_tel_no + ", rspt_email_nm="
				+ rspt_email_nm + ", trgtp_res_no=" + trgtp_res_no + ", chldbrth_dt=" + chldbrth_dt + ", divd_yn="
				+ divd_yn + ", term_cd=" + term_cd + ", mltpprgn_yn=" + mltpprgn_yn + ", usl_wage_cd=" + usl_wage_cd
				+ ", usl_wage_amt=" + usl_wage_amt + ", mm_fixed_labortm_dy=" + mm_fixed_labortm_dy + ", bizarea_cd="
				+ bizarea_cd + "]";
	}
}