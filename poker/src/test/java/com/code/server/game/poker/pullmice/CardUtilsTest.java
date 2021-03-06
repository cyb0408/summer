package com.code.server.game.poker.pullmice;

import com.code.server.game.poker.doudizhu.CardUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardUtilsTest {


    @Test
    public void test(){

        System.out.println("a");

        for (int i = 0; i < 54; i++){

            String str = CardUtils.local2String(i, new IfCard() {
                @Override
                public Map<Integer, Integer> cardDict() {
                    return CardUtils.getCardDict();
                }
            });

            System.out.println(str);
        }
    }

}