package kr.or.ddit.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionDIVO {
	private List<?> sampleList;
	private Set<String> sampleSet;
	private Map<String, ?> sampleMap;
	
	// props - map처럼 key, value(문자열로 제한) 형태 외부의 설정파일 형태로도 분리 가능
	private Properties props;

	private String[] array;
}
