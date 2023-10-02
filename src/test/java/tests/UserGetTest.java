package tests;

import com.bankofusa.api.controller.PlayerController;
import com.bankofusa.api.models.apiBody.players.GetPlayerResponseBody;
import com.bankofusa.api.models.apiBody.players.PlayersRequestBody;
import com.bankofusa.api.models.apiBody.players.PlayersResponseBody;
import com.bankofusa.api.utils.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.bankofusa.api.application.BaseEndPoints.*;

@Slf4j
public class UserGetTest extends BaseApiTest {
    PlayerController playerController;
    PlayersRequestBody playersRequestBody;
    GetPlayerResponseBody getPlayerResponseBody;
    List<PlayersResponseBody> playersResponseBodies;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        playerController = new PlayerController(BASE_URL);
        playersRequestBody = EntityManager.generatePlayerRequest();
        playersResponseBodies = new ArrayList<>();
    }

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


}


