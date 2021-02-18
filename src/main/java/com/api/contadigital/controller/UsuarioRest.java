package com.api.contadigital.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("rest/usuario")
@AllArgsConstructor
public class UsuarioRest {

//	@Autowired
//	private UsuarioService service;

//	@RequestMapping(value = "/", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
//	@ApiOperation(value = "efetua login de um usuário")
//	public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuario) {
//		Usuario user = service.login(usuario);
//		return new ResponseEntity<>(new UsuarioDTO(user), HttpStatus.OK);
//	}
//	
}
