package com.mjgpy3.sonicleet.parser;

import java.util.Collection;
import java.util.Iterator;

import com.mjgpy3.sonicleet.ast.IAstNode;
import com.mjgpy3.sonicleet.ast.SLInteger;
import com.mjgpy3.sonicleet.tokenizer.tokens.IToken;
import com.mjgpy3.sonicleet.tokenizer.tokens.TokenType;

public class Parser implements IParser {
	
	private IAstNode ast;
	
	private enum State {
		NONE,
		APPLY_ARGS,
	};
	
	public IAstNode parse(Collection<IToken> tokens) {
		System.out.println("Parse Begin");
		parseInState(tokens.iterator(), State.NONE);

		return ast;
	}
	
	public void parseInState(Iterator<IToken> tokens, State state) {
		IToken token = tokens.next();
		IAstNode node;
		State nextState = state;
		
		if (token.tokenType() == TokenType.WORD) {
			node = new Apply(token.value());
            nextState = State.APPLY_ARGS;
		} else {
            node = new SLInteger(token.value());
		}
		
		if (state == State.NONE) {
			ast = node;
		} else if (state == State.APPLY_ARGS) {
			((Apply) ast).addArg(node);
		}
		
		if (tokens.hasNext()) {
			parseInState(tokens, nextState);
		}
	}

}
