package com.airbnb.bookingservice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//less heavy than springboottest that loads whole app.
@WebMvcTest(LocationController.class)
@WithMockUser
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Autowired
    WebApplicationContext context;

//    @Before
//    public void setUp() {
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }

    @Test
    public void getLocation_ShouldReturnLocation() throws Exception {

        given(locationService.getLocationDetails(anyInt())).willReturn(new Location(1, "name", "city", (float) 4.2, 1));
        mockMvc.perform(MockMvcRequestBuilders.get("/locations/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").value(1));
//                .andExpect(jsonPath("").value(1));
    }

    @Test
    public void getLocation_notFound() throws Exception {
        given(locationService.getLocationDetails(anyInt())).willThrow(new LocationNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/locations/1"))
                .andExpect(status().isNotFound());
    }
}
