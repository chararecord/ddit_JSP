package kr.or.ddit.servlet07;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

public interface CommandOperator {
	public boolean fileCopy(Path source, Path dest, Optional option);
	public boolean fileMove(Path source, Path dest, Optional option);
}
