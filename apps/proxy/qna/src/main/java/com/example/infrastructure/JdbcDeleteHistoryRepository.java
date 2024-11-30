package com.example.infrastructure;

import com.example.domain.DeleteHistory;
import com.example.domain.DeleteHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deleteHistoryRepository")
public class JdbcDeleteHistoryRepository implements DeleteHistoryRepository {
    @Override
    public void saveAll(List<DeleteHistory> deleteHistories) {

    }
}
