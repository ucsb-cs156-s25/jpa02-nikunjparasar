package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

   
    @Test
    public void equals_returns_correct_value() {
        Team t1 = new Team("team");
        Team t2 = new Team("team");
        Team t3 = new Team("teams");
        String d = "9999";
        t1.members.add("a");
        t2.members.add("a");
        t3.members.add("a");
        assertEquals(t1.equals(t1), true);
        assertEquals(t1.equals(d), false);
        assertEquals(t1.equals(t2), true);
        assertEquals(t1.equals(t3), false);
        t2.members.add("b");
        assertEquals(t1.equals(t2), false);
        t3.members.add("b");
        assertEquals(t1.equals(t3), false);
    }

    @Test
    public void hash_returns_correct_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        Team t = new Team("test");
        t.addMember("foo");
        int result = t.hashCode();
        int expectedResult = 3656951;
        assertEquals(expectedResult, result);
    }

}
