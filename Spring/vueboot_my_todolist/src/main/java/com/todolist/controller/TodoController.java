package com.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.Result;
import com.todolist.dto.Todo;
import com.todolist.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:9090/클래스매핑값/메서드매핑값

@CrossOrigin(origins = { "*" })
@RequestMapping("/todolist")
@RestController
@Api("TodoList Rest API")
public class TodoController {

	@Autowired
	private TodoService todoService;

	// @GetMapping("/hello")
	public String hello() {
		return "hello world~!~";
	}

	//http://localhost:9090/todolist/todo
	@ApiOperation(value="사용자의 새로운 할일을 등록한다.", response=Result.class)
	@PostMapping("/todo")
	public ResponseEntity<Result> addTodo(@RequestBody Todo todo) { // @RestController이어도 @RequestBody 생략하면 안됨.
		System.out.println(todo);
		boolean flag = todoService.addTodo(todo);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "새로운 todo가 등록되었습니다. : " + todo.getId()), HttpStatus.OK);
		} 
		return new ResponseEntity<Result>(new Result(false, "todo 등록에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
	}//

	//http://localhost:9090/todolist/todo/id값
	@ApiOperation(value="등록되어 있는 할일을 수정한다.", response=Result.class)
	@PutMapping("/todo/{no}")
	public ResponseEntity<Result> modifyTodo(@PathVariable int no, @RequestBody Todo todo) {
		boolean flag = todoService.modifyTodo(todo); //no는 전달 안되네. 없어도 될듯
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "todo가 수정되었습니다. : " + no), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, "todo 수정에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	//http://localhost:9090/todolist/todo/id값
	@ApiOperation(value="등록되어 있는 할일을 삭제한다.", response=Result.class)
	@DeleteMapping("/todo/{no}")
	public ResponseEntity<Result> removeTodo(@PathVariable int no) {
		boolean flag = todoService.removeTodo(no);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "todo가 삭제되었습니다. : " + no), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, "todo 삭제에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}//
	
	//http://localhost:9090/todolist/todo/id값
	@ApiOperation(value="등록되어 있는 할일을 조회한다.", response=Todo.class) //id기준 1개 조회
	@GetMapping("/todo/{no}")
	public ResponseEntity<Todo> findTodo(@PathVariable int no) {
		Todo todo = todoService.findTodo(no);
		if (todo != null) {
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		}
		return new ResponseEntity<Todo>(HttpStatus.NO_CONTENT);
	}

	//http://localhost:9090/todolist/user/userid값
	@ApiOperation(value="사용자의 모든 할일목록을 조회한다.", response=List.class)
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Todo>> findTodoList(@PathVariable String userId) {
		List<Todo> todoList = todoService.findTodoList(userId);
		if (todoList.size() > 0) {
			return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Todo>>(HttpStatus.NO_CONTENT);
	}
	
	//http://localhost:9090/todolist/all
	@ApiOperation(value="모든 할일목록을 조회한다.", response=List.class)
	@GetMapping("/all")
	public ResponseEntity<List<Todo>> allTodoList() {
		List<Todo> todoList = todoService.allTodoList();
	System.out.println( todoList.get(0));
		if (todoList.size() > 0) {
			return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Todo>>(HttpStatus.NO_CONTENT);
	}//

	//http://localhost:9090/todolist/user/userid값
	@ApiOperation(value="사용자의 모든 할일목록을 삭제한다.", response=List.class)
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Result> deleteTodoList(@PathVariable String userId) {
		boolean flag = todoService.removeTodoList(userId);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, userId+"의 todoList가 삭제되었습니다." ), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, userId+"의 todoList 삭제에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//http://localhost:9090/todolist/todo/done/id값
	@ApiOperation(value="등록되어 있는 할일을 완료 처리한다.", response=Result.class)
	@PutMapping("/todo/done/{no}")
	public ResponseEntity<Result> completeTodo(@PathVariable int no) {
		boolean flag = todoService.completeTodo(no);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "todo가 완료 처리되었습니다. : " + no), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, "todo 완료처리에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}//
	
}
