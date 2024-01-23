package com.hk.board.daos;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.hk.ans.config.SqlMapConfig;

import com.hk.board.dtos.HkDto;


public class HkDao extends SqlMapConfig {
	
	private String namespace="com.hk.board.";
	

	//글목록 조회 기능 : 반환값 List<HkDto> -> 여러개의 행일 경우  
	public List<HkDto> getAllList(String pnum){   // 맨날 여기 틀림 제발 파라미터 줘라!!!!!
		List<HkDto> list = new ArrayList<>();
		
		SqlSession sqlSession = null;
		
		Map<String, String>map =new HashMap<>();
		map.put("pnum", pnum); // 페이지 번호 저장
		
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			list = sqlSession.selectList(namespace + "boardList",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	
	// 1-2. 페이지수 구하기
	public int getPCount() {
		int count = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.selectOne(namespace + "getPCount");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count;
	}
		
		
	//2.새글추가하기
	public boolean insertBoard(HkDto dto) {
		int count=0;
		SqlSession sqlSession=null;
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			//파리미터 타입: DTO,Array,Map(파라미터 기본 타입)
			//            값한개(int,String해당타입으로 정의)
			count=sqlSession.insert(namespace+"insertBoard",dto);
		} catch (Exception e) {
			e.printStackTrace();// <--이게 없으면 오류 출력안됨
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
		
	
	
	//3.상세조회
	public HkDto getBoard(int seq) {
		HkDto dto=null;
		//쿼리를 실행하려면 필요한 객체는 뭐다?
		SqlSession sqlSession=null;
		
		//Map에 담아서 파라미터 전달하기
		Map<String, Integer>map=new HashMap<>();
		map.put("seq", seq);
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);

			dto=sqlSession.selectOne(namespace+"getBoard", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dto;
	}
	
	
	
	//4.수정하기
	public boolean updateBoard(HkDto dto) {
		int count=0;
		SqlSession sqlSession=null;
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.update(namespace+"updateBoard", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	//5.조회수
		public boolean readCount(int seq) {
			int count=0;
			SqlSession sqlSession=null;
			try {
				sqlSession=getSqlSessionFactory().openSession(true);
				count=sqlSession.update(namespace+"readCount", seq);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count>0?true:false;
		}
		
		//6.삭제하기
	public boolean mulDel(String[] seqs) {
		int count=0;
		SqlSession sqlSession=null;
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);
		
		try {
			sqlSession=getSqlSessionFactory().openSession(true);
			count=sqlSession.update(namespace+"mulDel", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return count>0?true:false;
	}
	
	
	public void test() {
		//쿼리를 실행시킬 수 있는 객체 : sqlSession객체를 구함
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		//쿼리를 실행한다.--> sqlMapper.xml에 있는 쿼리를 실행한거임
		List<HkDto>list= sqlSession.selectList("boardList");
	}
	
}











