package com.hk.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.board.dtos.HkDto;
import com.hk.board.service.HkService;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	@Autowired
	private HkService boardService;
	
	// 글목록 요청
//	@CrossOrigin(origins = "http://localhost:8086")
	@GetMapping("/boardlist")
	public Map<String, List<HkDto>> boardList(){
		
		System.out.println("글목록 요청");
		// 글목록 데이터 list객체를 Map에 저장한다. --> json{"list":list}
		// --> json : {"list":[dto,dto,dto...]}
		Map<String, List<HkDto>> map = new HashMap<>();
		map.put("list", boardService.getAllList());
		
		return map;
	}
	
	//글추가하기:전달파라미터 id, title, content
	@PostMapping("/insert")
	public Map<String, Integer> insert(HkDto dto){
		System.out.println("글 추가하기");
		Map<String, Integer> map = new HashMap<>();
		map.put("count",boardService.insertBoard(dto));
		return map;
	}
	
	//글추가하기:전달파라미터 seq, title, content
	@GetMapping("/detail/{seq}")
	public Map<String, HkDto> detail(@PathVariable int seq){
		System.out.println("글 상세");
		Map<String, HkDto> map = new HashMap<>();
		map.put("dto",boardService.getBoard(seq));
		return map;
	}
	
	//글수정하기 폼이동:전달파라미터 seq
	@GetMapping("/updateform/{seq}")
	public Map<String, HkDto> updateForm(@PathVariable int seq){
		System.out.println("글 수정하기 폼이동");
		Map<String, HkDto> map = new HashMap<>();
		map.put("dto",boardService.getBoard(seq));
		return map;
	}
	
	//글수정하기 폼이동:전달파라미터 seq
	@PutMapping("/update")
	public Map<String, Integer> update(HkDto dto){
		System.out.println("글 수정하기 ");
		Map<String, Integer> map = new HashMap<>();
		map.put("dto",boardService.updateBoard(dto));
		return map;
	}
	
//	//글
//	@DeleteMapping("/delete/{seq}")
//	public Map<String, Integer> update(@PathVariable int seq){
//		System.out.println("글 삭제 ");
//		Map<String, Integer> map = new HashMap<>();
//		map.put("dto",boardService.deleteBoard(seq));
//		return map;
//	}
	
   //글삭제하기: 전달파라미터 seq
   @DeleteMapping("/muldel")
   public Map<String, Integer> muldel(@RequestParam String[] chk){
      System.out.println("글 여러개 삭제하기");
      Map<String, Integer> map=new HashMap<>();
      map.put("count", boardService.mulDel(chk));
      return map;
   }

}
