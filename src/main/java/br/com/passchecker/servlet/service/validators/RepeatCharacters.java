package br.com.passchecker.servlet.service.validators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.passchecker.servlet.service.PassCheckable;
import br.com.passchecker.servlet.service.StrengthStatus;

public class RepeatCharacters implements PassCheckable {

	@Override
	public Integer bonus(String pass) {
		double nRepInc = 0;
		double nRepChar = 0;
		double length = pass.length();
		for (int a = 0; a < length; a++) {
			boolean bCharExists = false;
			for (int b = 0; b < length; b++) {
				if (pass.charAt(a) == pass.charAt(b) && a != b) {
					bCharExists = true;
					nRepInc += Math.abs(length / (b - a));
				}
			}
			if (bCharExists) {
				nRepChar++;
				double nUnqChar = length - nRepChar;
				nRepInc = nUnqChar != 0 ? Math.ceil(nRepInc / nUnqChar) : Math
						.ceil(nRepInc);
			}
		}
		return (int) -nRepInc;
	}

	@Override
	public void bonus(StrengthStatus status, String pass) {
		status.addBonus(bonus(pass));
	}

	@Override
	public int occurrences(String pass) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int count = 0;
		for (int i = 0; i < pass.length(); i++) {
			if (!stored(pass, map, i)) {
				int quantitySame = 0;
				for (int cursor = i + 1; cursor < pass.length(); cursor++) {
					if (!stored(pass, map, i)
							&& pass.charAt(i) == pass.charAt(cursor)) {
						quantitySame = 2;
						map.put(Character.toString(pass.charAt(i)), 0);
						continue;
					}
					if (pass.charAt(i) == pass.charAt(cursor)) {
						quantitySame++;
					}
				}
				count += quantitySame;
			}
		}
		return count;
	}

	private boolean stored(String pass, Map<String, Integer> map, int i) {
		return map.get(Character.toString(pass.charAt(i))) != null;
	}

	public List<String> toListString(String string) {
		char[] charArray = string.toCharArray();
		List<String> list = new ArrayList<String>();
		for (char c : charArray) {
			list.add(Character.toString(c));
		}
		return list;
	}
}
