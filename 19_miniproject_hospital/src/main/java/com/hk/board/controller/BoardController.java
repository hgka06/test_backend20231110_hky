package com.hk.board.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.board.command.InsertBoardCommand;
import com.hk.board.command.UpdateBoardCommand;
import com.hk.board.dtos.BoardDto;
import com.hk.board.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/board")
public class BoardController {
   
   @Autowired
   private BoardService boardService;
   
   @GetMapping(value = "/boardList")
   public String boardList(Model model) {
      System.out.println("글목록 보기");
      
      List<BoardDto> list=boardService.getAllList();
      model.addAttribute("list", list);
    //  model.addAttribute("delBoardCommand", new DelBoardCommand());
      return "board/boardList";// forward 기능, "redirect:board/boardList"
   }
   
   @GetMapping(value = "/boardInsert")
   public String boardInsertForm(Model model) {
      model.addAttribute("insertBoardCommand", new InsertBoardCommand());
      return "board/boardInsertForm";
   }
   
   @PostMapping(value = "/boardInsert")
   public String boardInsert(@Validated InsertBoardCommand insertBoardCommand 
                         ,BindingResult result
                         ,MultipartRequest multipartRequest //multipart data를 처리할때 사용
                     ,HttpServletRequest request
                         ,Model model) throws IllegalStateException, IOException {
      if(result.hasErrors()) {
         System.out.println("글을 모두 입력하세요");
         return "board/boardInsertForm";
      }
      
      boardService.insertBoard(insertBoardCommand,multipartRequest
                            ,request);
      
      return "redirect:/board/boardList";
   }
   
 //상세보기
   @GetMapping(value="/boardDetail")
   public String boardDeString(int board_seq, Model model) {
      BoardDto dto=boardService.getBoard(board_seq);
      
      //유효값 처리용
      model.addAttribute("updateBoardCommand", new UpdateBoardCommand());
      //출력용
      model.addAttribute("dto",dto);
      
      return "board/boardDetail";
   }
   
   @PostMapping(value = "/boardUpdate")
   public String boardUpdate(@Validated UpdateBoardCommand updateBoardCommand, BindingResult result) {
	   
	   if(result.hasErrors()) {
		   System.out.println("수정내용을 모두 입력하세요");
		   return "board/boardDetail";
	   }
	   
	   boardService.updateBoard(updateBoardCommand);
	   
	   return "redirect:/board/boardDetail?board_seq=" + updateBoardCommand.getBoard_seq();
   }
}