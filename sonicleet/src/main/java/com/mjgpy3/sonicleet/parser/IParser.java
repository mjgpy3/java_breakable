package com.mjgpy3.sonicleet.parser;

import java.util.Collection;

import com.mjgpy3.sonicleet.ast.IAstNode;
import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;

public interface IParser {

	IAstNode parse(Collection<IToken> given);

}
