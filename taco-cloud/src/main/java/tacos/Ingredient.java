package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate; 



@Data
@RequiredArgsConstructor
public class Ingredient {

	private final String id;
	private final String name;
	private final Type type;
	private JdbcTemplate jdbc;

	
	public static enum Type {WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE}
	
	

}
