package foo;

import java.util.Random;

public class Omojan{

	final static String[] words = new String[]{
		"�V���[��p","�U�N","�͂��߂Ă�","�`���[",
		"�ɓ���","�Ȃ���","���悤�Ȃ�","�O�p","���͂悤",
		"101��ڂ�","�v���|�[�Y","�r������","80�L��",
		"�o����","�s���`�ł�","����","�Ԃ�",
	};

	private String getSinglegWord(){
		int index = new Random().nextInt(words.length);
		return words[index];
	}

	public String getWord(){
		return getSinglegWord() + " " + getSinglegWord();
	}
}