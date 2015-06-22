package org.icodeit.bookmarks.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.icodeit.bookmarks.model.Feed;
import org.icodeit.bookmarks.service.FeedsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class FeedsControllerTest {
    private MockMvc mockMvc;
    private FeedsController feedsController;
    private FeedsService feedsService;

    @Before
    public void setup() {
        feedsService = mock(FeedsService.class);
        feedsController = new FeedsController();
        feedsController.setFeedsService(feedsService);

        mockMvc = standaloneSetup(feedsController).build();
    }

    @Test
    public void shouldResponseWithAllFeeds() throws Exception {
        when(feedsService.allFeeds()).thenReturn(Arrays.asList(prepareFeeds()));

        mockMvc.perform(get("/api/feeds"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].publishDate", is(notNullValue())));
    }

    private Feed[] prepareFeeds() throws IOException {
        URL resource = getClass().getResource("/mocks/feeds.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource, Feed[].class);
    }

    private Feed[] prepareFavoriteFeeds() throws IOException {
        URL resource = getClass().getResource("/mocks/fav-feeds.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resource, Feed[].class);
    }
}