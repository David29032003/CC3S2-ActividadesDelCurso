import FootballTeam.FootballTeam;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class FootballTeamTest2 {

   @ParameterizedTest
   @ValueSource(ints = {0,1,3,10}) //arrange the values we want to test
   void constructorShouldSetGamesWon(int nbOfGamesWon) {
       FootballTeam team = new FootballTeam(nbOfGamesWon); //act
       //assert
       assertThat(team.getGamesWon())
               .as("number of games won")
               .isEqualTo(nbOfGamesWon);
   }

   @ParameterizedTest
   @ValueSource(ints = {-10,-3,-1}) //arrange the values we want to test
    void constructorShouldThrowExceptionForIllegalGamesNb(int illgalnbOfGamesWon) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> { new FootballTeam(illgalnbOfGamesWon);});
    }

    private static final int ANY_NUMBER = 123;
   @Test
    void shouldBePossibleToCompareTeams(){
       FootballTeam team = new FootballTeam(ANY_NUMBER);
       assertThat(team).isInstanceOf(Comparable.class); //usamos la interfaz Comparable
   }

   @Test
    void TeamsWithMoreMatchesWonShouldBeGreater(){
       FootballTeam team_2= new FootballTeam(2);
       FootballTeam team_3= new FootballTeam(3);
       assertThat(team_3.compareTo(team_2)).isGreaterThan(0);

   }
    @Test
    void  teamsWithSameNumberOfMatchesWonShouldBeEqual(){
        FootballTeam teamA= new FootballTeam(2);
        FootballTeam teamB= new FootballTeam(2);
        assertThat(teamB.compareTo(teamA)).isEqualTo(0);

    }

}
