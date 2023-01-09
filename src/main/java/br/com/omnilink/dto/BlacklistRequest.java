package br.com.omnilink.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BlacklistRequest {
	@NotBlank
    private String text;

    public String toString() {
        return this.text.toLowerCase();
    }
}