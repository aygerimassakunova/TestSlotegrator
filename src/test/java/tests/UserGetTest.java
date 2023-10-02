package tests;

import com.bankofusa.api.asserts.ApiAssert;
import com.bankofusa.api.controller.PlayerController;
import com.bankofusa.api.models.apiBody.players.GetPlayerResponseBody;
import com.bankofusa.api.models.apiBody.players.PlayersRequestBody;
import com.bankofusa.api.models.apiBody.players.PlayersResponseBody;
import com.bankofusa.api.utils.EntityManager;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.bankofusa.api.application.BaseEndPoints.*;

@Slf4j
public class UserGetTest extends BaseApiTest {
    @Test
    public void test() {
        log.info("Generated next request body: {}", playersRequestBody);
        for (int i = 0; i < 12; i++) {
            PlayersResponseBody playersResponseBody = playerController.createPlayer(playersRequestBody);
            playersResponseBodies.add(playersResponseBody);
            log.info("Creating next player: {}", playersResponseBody);
            getPlayerResponseBody = playerController.getOneUserByEmail(playersResponseBody.getEmail());
            Assert.assertNotNull(getPlayerResponseBody.getEmail());
        }
        GetPlayerResponseBody[] allUsers = playerController.getAllUsers();
        Assert.assertEquals(allUsers.length, 12);
        for (PlayersResponseBody playersResponseBody : playersResponseBodies) {
            playerController.deletePlayer(playersResponseBody.getId());
        }
        allUsers = playerController.getAllUsers();
        Assert.assertEquals(allUsers.length, 0);
    }
    @Test
    public void codeTest(){
        ApiAssert.assertThat(apiRequest.getResponse()).isCorrectStatusCode(200);
        ApiAssert.assertThat(apiRequest.getResponse()).isNotNull("accessToken");
        }


}


