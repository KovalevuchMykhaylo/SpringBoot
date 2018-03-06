package com.shop.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.shop.dto.filters.SimpleFilter;

/**
 * Interface user for add params to link;
 */
public interface ParamBuilder {

    /**
     * Add patams to link
     *
     * @param pageable spring dominant pageable
     * @return params with sorting
     */
    static String getParams(Pageable pageable) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("?page=");
        buffer.append(String.valueOf(pageable.getPageNumber() + 1));
        buffer.append("&size=");
        buffer.append(String.valueOf(pageable.getPageSize()));
        if (pageable.getSort() != null) {
            buffer.append("&sort=");
            Sort sort = pageable.getSort();
            sort.forEach((order) -> {
                buffer.append(order.getProperty());
                if (order.getDirection() != Direction.ASC)
                    buffer.append(",desc");
            });
        }
        return buffer.toString();
    }

    /**
     * Adds params to link
     *
     * @param pageable spring dominant pageable
     * @param filter   filter with one string param
     * @return params with sorting and filter param
     */
    static String getParams(Pageable pageable, SimpleFilter filter) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("?page=");
        buffer.append(String.valueOf(pageable.getPageNumber() + 1));
        buffer.append("&size=");
        buffer.append(String.valueOf(pageable.getPageSize()));
        if (pageable.getSort() != null) {
            buffer.append("&sort=");
            Sort sort = pageable.getSort();
            sort.forEach((order) -> {
                buffer.append(order.getProperty());
                if (order.getDirection() != Direction.ASC)
                    buffer.append(",desc");
            });
        }
        if (!filter.getSearch().isEmpty()) {
            buffer.append("&search=");
            buffer.append(filter.getSearch());
        }
        return buffer.toString();
    }
}
