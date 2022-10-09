package com.example.bookmarkerapi.domain;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookmarkService {

  private final BookmarkRepository bookmarkRepository;
  private final BookmarkMapper bookmarkMapper;

  @Transactional(readOnly = true)
  public BookmarksDTO getBookmarks(Integer page) {
    int pageNo = page < 1 ? 0 : page - 1;
    Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
    final Page<BookmarkDTO> bookmarkDTOS = bookmarkRepository.findBookmarks(pageable);
    return new BookmarksDTO(bookmarkDTOS);
  }
}
