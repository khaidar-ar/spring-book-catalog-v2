package com.springboot.catalog.util;

import com.springboot.catalog.dto.ResultPageResponseDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PaginationUtil {

    public static <T> ResultPageResponseDTO<T> createResultPageDTO(List<T> result, Integer pages, Integer content) {
        ResultPageResponseDTO<T> resultPageResponseDTO = new ResultPageResponseDTO<>();
        resultPageResponseDTO.setResult(result);
        resultPageResponseDTO.setPages(pages);
        resultPageResponseDTO.setContents(content);
        return resultPageResponseDTO;
    }

    public static Sort.Direction sortBy(String sortBy) {
        if (sortBy.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        } else {
            return Sort.Direction.DESC;
        }
    }
}
