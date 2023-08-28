package com.douzone.comet.service.hr.pammpm.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.comet.jdbc.mybatis.DzMybatisSupport;
import com.douzone.comet.service.hr.pammpm.models.Pammpm00200_Model;
/** 
  * @description :
  * @Since   : 
  * @Author  :
  * @History :
  */
@Repository
public class Pammpm00200_Dao  {

	private DzMybatisSupport mybatisSupport;

	@Autowired
	public Pammpm00200_Dao(DzMybatisSupport mybatisSupport) {
		this.mybatisSupport = mybatisSupport;
	}

	//마스터복수 데이터 목록 조회
	public List<Pammpm00200_Model> Pammpm00200_selectAllData(HashMap<String, Object> parameter) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".Pammpm00200_selectAllData", parameter);
	}
	
	//서브복수 데이터 목록 조회
	public List<HashMap<String,Object>> Pammpm00200_selectHrMtnityidnfDtl(HashMap<String, Object> parameter) throws Exception {
		return this.mybatisSupport.selectList(this.getClass().getName() + ".Pammpm00200_selectHrMtnityidnfDtl", parameter);
	}

	/**
	 * 단일 데이터 조회
	 * @param pammpm00200_Model
	 * @return List<Pammpm00200_Model>
	 */
	public Pammpm00200_Model selectPammpm00200_Model(Pammpm00200_Model pammpm00200_Model) throws Exception {
		return this.mybatisSupport.selectOne(this.getClass().getName() + ".selectPammpm00200_Model", pammpm00200_Model);
	}

	/**
	 * 단일 데이터 입력 처리
	 * @param pammpm00200_Model
	 */
	public void insertPammpm00200_Model(Pammpm00200_Model pammpm00200_Model) throws Exception {
		this.mybatisSupport.insert(this.getClass().getName() + ".insertPammpm00200_Model", pammpm00200_Model);
	}

	/**
	 * 단일 데이터 수정 처리
	 * @param pammpm00200_Model
	 */
	public void updatePammpm00200_Model(Pammpm00200_Model pammpm00200_Model) throws Exception {
		this.mybatisSupport.update(this.getClass().getName() + ".updatePammpm00200_Model", pammpm00200_Model);
	}

	/**
	 * 단일 데이터 삭제 처리
	 * @param pammpm00200_Model
	 */
	public void deletePammpm00200_Model(Pammpm00200_Model pammpm00200_Model) throws Exception {
		this.mybatisSupport.delete(this.getClass().getName() + ".deletePammpm00200_Model", pammpm00200_Model);
	}

	public List<HashMap<String, Object>> selectPammpm00200_ModelList(HashMap<String, Object> parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pammpm00200_Model> pammpm00200_service_list(HashMap<String, Object> parameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
