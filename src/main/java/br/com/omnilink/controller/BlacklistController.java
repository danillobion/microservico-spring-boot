package br.com.omnilink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnilink.dto.BlacklistRequest;
import br.com.omnilink.dto.BlacklistResponse;
import br.com.omnilink.facade.Facade;

@RestController
@RequestMapping("/blacklist/")
public class BlacklistController {

	@Autowired
	private Facade facade;
	
	@PostMapping(value = "/isTextClean")
	public BlacklistResponse isTextClean(@RequestBody BlacklistRequest blacklistRequest) {
		return facade.isTextClean(blacklistRequest);
	}
	
}
