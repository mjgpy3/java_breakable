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
		State state = State.NONE;

		for (IToken token : tokens) {
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

			state = nextState;
		}

		return ast;
	}
}
