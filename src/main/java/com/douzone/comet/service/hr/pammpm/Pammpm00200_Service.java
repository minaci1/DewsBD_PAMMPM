package com.douzone.comet.service.hr.pammpm;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.douzone.comet.components.DzCometService;
import com.douzone.comet.service.hr.pammpm.dao.Pammpm00200_Dao;
import com.douzone.comet.service.hr.pammpm.models.Pammpm00200_Model;
import com.douzone.gpd.components.exception.DzApplicationRuntimeException;
import com.douzone.gpd.restful.annotation.DzApi;
import com.douzone.gpd.restful.annotation.DzApiService;
import com.douzone.gpd.restful.annotation.DzParam;
import com.douzone.gpd.restful.enums.CometModule;
import com.douzone.gpd.restful.enums.DzParamType;
import com.douzone.gpd.restful.enums.DzRequestMethod;
import com.douzone.gpd.restful.model.DzGridModel;

/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@DzApiService(value="Pammpm00200_Service", module=CometModule.HR, desc="인사관리 - 모성보호관리")
public class Pammpm00200_Service extends DzCometService {

	@Autowired
	private Pammpm00200_Dao dao; 

	@DzApi(url="/pammpm00200_service_list", desc="출산휴가확인서등록-조회", httpMethod=DzRequestMethod.POST)
	public List<Pammpm00200_Model> pammpm00200_service_list(
		@DzParam(key="wrt_dt_start", desc="시작일", required= false, paramType = DzParamType.Body) String wrt_dt_start,
		@DzParam(key="wrt_dt_end", desc="종료일",required= false, paramType = DzParamType.Body) String wrt_dt_end,
		@DzParam(key="req_knd_fg", desc="신청종류",required= false, paramType = DzParamType.Body) String req_knd_fg,
		@DzParam(key="emp_no", desc="사원번호",required= false,paramType = DzParamType.Body)String emp_no,
		@DzParam(key="kor_nm", desc="사원이름",required= false,paramType = DzParamType.Body)String kor_nm
	) throws Exception {
		List<Pammpm00200_Model> pammpm00200_ModelList =  new ArrayList<Pammpm00200_Model>();
		System.out.println("???");
		try {
		    System.out.println("???");
			HashMap<String,Object> parameter = new HashMap<String, Object>();
	 		parameter.put("P_WRT_DT_START",wrt_dt_start);
	 		parameter.put("P_WRT_DT_END",wrt_dt_end);
	 		parameter.put("P_COMPANY_CD", this.getCompanyCode());
	 		System.out.println("P_COMPANY_CD"+this.getCompanyCode());
	 		parameter.put("P_REQ_KND_FG", req_knd_fg);
	 		parameter.put("P_EMP_NO",emp_no);
	 		parameter.put("P_KOR_NM", kor_nm);
	 		System.out.println(parameter.toString());
	 		
	 		pammpm00200_ModelList = dao.pammpm00200_service_list(parameter);
	 		
	 		for(Pammpm00200_Model item : pammpm00200_ModelList) {
				item.set_uid(UUID.randomUUID().toString());
			}
	 		
	 		
	 	} catch(Exception e) {
	        throw new DzApplicationRuntimeException(e);
	    }
	    return pammpm00200_ModelList;
 	}

//	@Transactional(rollbackFor = Exception.class)
//	@DzApi(url="/pammpm00200_service_save", desc="출산휴가확인서등록-저장", httpMethod=DzRequestMethod.POST)
//	public void pammpm00200_service_save(
//		@DzParam(key="w", desc="2", paramType = DzParamType.Body) DzGridModel<Pammpm00200_Model> w,
//		@DzParam(key="e", desc="3", paramType = DzParamType.Body) DzGridModel<Pammpm00200_Model> e
//	) throws Exception {	    
//	    try {	        	        
//	        // update
//	        for(Pammpm00200_Model pammpm00200_Model : w.getUpdated()) {
//	        	dao.updatePammpm00200_Model(pammpm00200_Model);
//	        }
//	        
//	        // delete
//	        for(Pammpm00200_Model pammpm00200_Model : w.getDeleted()) {
//	        	dao.deletePammpm00200_Model(pammpm00200_Model);
//	        }
//	        
//	        // add
//	        for(Pammpm00200_Model pammpm00200_Model : w.getAdded()) {
//	        	dao.insertPammpm00200_Model(pammpm00200_Model);
//	        }
//	        
//	    } catch (Exception e) {
//	        throw new DzApplicationRuntimeException(e);
//	    }
//	}
}
