package br.com.omnilink.blacklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnilink.blacklist.dto.BlacklistRequest;
import br.com.omnilink.blacklist.dto.BlacklistResponse;
import br.com.omnilink.blacklist.facade.Facade;

@RestController
@RequestMapping("blacklist")
public class BlacklistController {

	@Autowired
	private Facade facade;
	
	@PostMapping(value = "/isTextClean")
	public BlacklistResponse isTextClean(@RequestBody BlacklistRequest blacklistRequest) {
		return facade.isTextClean(blacklistRequest);
	}
	
}
