package com.example.framework.adapter.out.persistence;

import com.example.domain.entity.DeleteHistory;
import com.example.domain.repository.DeleteHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deleteHistoryRepository")
public class JdbcDeleteHistoryRepository implements DeleteHistoryRepository {
    @Override
    public void saveAll(List<DeleteHistory> deleteHistories) {

    }
}
