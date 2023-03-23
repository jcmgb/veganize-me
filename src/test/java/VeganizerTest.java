import org.jcmgb.veganizer.VeganizeMeApplication;
import org.jcmgb.veganizer.entity.Recipe;
import org.jcmgb.veganizer.repository.RecipeRepository;
import org.jcmgb.veganizer.service.VeganizerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = VeganizeMeApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class VeganizerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeRepository recipeRepository;

    @SpyBean
    private VeganizerService veganizerService;

    public static List<Recipe> mockRecipes = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        Recipe mockRecipe = new Recipe();
        mockRecipe.setTitle("Mock recipe title");
        mockRecipe.setIngredients("mock eggs");

        Recipe mockRecipe2 = new Recipe();
        mockRecipe2.setTitle("Mock recipe title 2");
        mockRecipe2.setIngredients("mock eggs");

        mockRecipes.add(mockRecipe);
        mockRecipes.add(mockRecipe2);
    }

    @Test
    public void getAllRecipes() throws Exception {
        Mockito.when(recipeRepository.findAll()).thenReturn(mockRecipes);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/recipes"))
                .andExpect(status().isOk())
                .andReturn();

        String contentResult = mvcResult.getResponse().getContentAsString();
        JSONObject recipeDataObject = new JSONArray(contentResult).getJSONObject(0);
        assertEquals(recipeDataObject.get("title"), mockRecipes.get(0).getTitle());

        Mockito.verify(recipeRepository, atLeast(1)).findAll();
    }

    @Test
    public void duplicateTitleNegative() throws Exception {
        Mockito.when(recipeRepository.findByTitle(any())).thenReturn(mockRecipes.get(1));

        JSONObject body = new JSONObject();
        body.put("title", mockRecipes.get(1).getTitle());
        body.put("ingredients", mockRecipes.get(1).getIngredients());

        mockMvc.perform(MockMvcRequestBuilders.post("/veganize")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body.toString()))
                .andExpect(status().is4xxClientError())
                .andReturn();

        Mockito.verify(veganizerService, atLeast(1)).veganize(any());
    }
}
