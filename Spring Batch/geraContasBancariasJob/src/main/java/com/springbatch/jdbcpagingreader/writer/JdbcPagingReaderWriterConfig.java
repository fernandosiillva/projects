package com.springbatch.jdbcpagingreader.writer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.springbatch.jdbcpagingreader.dominio.Conta;


@Configuration
public class JdbcPagingReaderWriterConfig {

	@Bean
	public JdbcBatchItemWriter<Conta> jdbcBatchItemWriter(@Qualifier("appDataSource") DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<Conta>()
				.dataSource(dataSource)
				.sql("INSERT INTO conta (tipo, limite, cliente_id) VALUES (?, ?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
	}

	private ItemPreparedStatementSetter<Conta> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<Conta>() {

			@Override
			public void setValues(Conta conta, PreparedStatement ps) throws SQLException {
				ps.setString(1, conta.getTipo().name());
				ps.setDouble(2, conta.getLimite());
				ps.setString(3, conta.getClienteId());
			}
		};
	}
	
//	@Autowired
//	private ContaRepository contaRepository;
//	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean
//	public ItemWriter contasBancariasWriter() {
//		return conta  -> conta.forEach(new Consumer<Conta>() {
//
//			@Override
//			public void accept(Conta conta) {
//				contaRepository.save(conta);
//			}
//		});
//		
//	}
}
