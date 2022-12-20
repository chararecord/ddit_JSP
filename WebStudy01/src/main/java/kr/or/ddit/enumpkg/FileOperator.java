package kr.or.ddit.enumpkg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.Optional;

import kr.or.ddit.servlet07.CommandOperator;

public enum FileOperator {
	COPY("COPY", (source, dest, option) -> Files.copy(sourceFile.toPath(), destFilePath, StandardCopyOption.REPLACE_EXISTING),
	MOVE("MOVE", (source, dest, option) -> Files.move(sourceFile.toPath(), destFilePath, StandardCopyOption.REPLACE_EXISTING);
//	DELETE();

	private char sign;
	private CommandOperator commandOperator;
	
	private FileOperator(char sigin, CommandOperator commandOperator) {
		this.sign = sigin;
		this.commandOperator = commandOperator;
	}
	
	public char getSign() {
		return sign;
	}
	public boolean fileCopy(Path source, Path dest, Optional option) {
		return commandOperator.fileCopy(source, dest, option);
	}
	public boolean fileMove(Path source, Path dest, Optional option) {
		return commandOperator.fileMove(source, dest, option);
	}
	
}
