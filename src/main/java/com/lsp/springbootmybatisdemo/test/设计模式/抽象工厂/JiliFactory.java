package com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂;

import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.chairEntity.ChairA;
import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.chairEntity.ChairB;
import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.engineEntity.EngineA;
import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.engineEntity.EngineB;
import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.interfaces.Chair;
import com.lsp.springbootmybatisdemo.test.设计模式.抽象工厂.interfaces.Engine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * @FileName: JiliFactory
 * @Description:  吉利组装厂
 * @AuthOr: lsp
 * @Date: 2020/1/10 21:32
 */
@Slf4j
public class JiliFactory implements CarFactory {
    @Override
    public Engine makeEngine(String name) {
      Engine engine = null;
      if (StringUtils.isNotBlank(name)){
          if (name.equalsIgnoreCase("engineA")){
              engine = new EngineA();
          }
          if (name.equalsIgnoreCase("engineB")){
              engine = new EngineB();
          }else {
              log.info("不存在");
          }
      }else {
          log.info("不能为空");
      }

      return engine;
    }

    @Override
    public Chair makeChair(String name) {
        Chair chair = null;
        if (StringUtils.isNotBlank(name)){
            if (name.equalsIgnoreCase("chairA")){
                chair = new ChairA();
            }
            if (name.equalsIgnoreCase("chairB")){
                chair = new ChairB();
            }else {
                log.info("不存在");
            }
        }else {
            log.info("不能为空");
        }
        return chair;
    }
}
