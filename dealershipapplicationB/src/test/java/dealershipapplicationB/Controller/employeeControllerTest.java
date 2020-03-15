//package dealershipapplicationB.Controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasProperty;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class employeeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
////    public void getAllEmployeesTest() throws Exception {
////        mockMvc.perform(get("list"))
////                .andExpect(model().attribute("", any(EmployeeController.class)))
////                .andExpect(view().name("list"))
////                .andExpect(status().isOk());
////    }
//
//    public void deleteEmployeeByIdTest() throws Exception {
//        this.mockMvc
//                        .perform(post("delete/{id}")
//                            .param("id", "*")
//                            .contentType(MediaType.APPLICATION_FORM_URLENCODED))
//                        .andExpect(status().is3xxRedirection())
//                        .andExpect(flash().attribute("", hasProperty("textField", equalTo("*"))));
//
//
//    }
//
//}
