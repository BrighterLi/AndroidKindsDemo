package com.a006designmode.structuralmode.adaptermode;

import com.a006designmode.structuralmode.adaptermode.db.DBSocketInterface;
import com.a006designmode.structuralmode.adaptermode.gb.GBSocketInterface;


/**
* 中国插座和适配器这两个东西是我带到德国去的，目前他们还不能使用，因为接口不一样。那么我必须创建一个适配器，这个适配器必须满足以下条件：
 *
 * 1    必须符合德国标准的接口，否则的话还是没办法插到德国插座中；
 * 2    在调用上面实现的德标接口进行充电时，提供一种机制，将这个调用转到对国标接口的调用 。
 *
 * 这就要求：
 * 1 适配器必须实现原有的旧的接口
 * 2 适配器对象中持有对新接口的引用，当调用旧接口时，将这个调用委托给实现新接口的对象来处理，也就是在适配器对象中组合一个新接口。
* */
public class SocketAdapter implements DBSocketInterface { //实现德标旧接口

    //组合新接口
    private GBSocketInterface gbSocket;

    /**
     * 在创建适配器对象时，必须传入一个新接口的实现类
     * @param gbSocket
     */
    public SocketAdapter(GBSocketInterface gbSocket) {
        this.gbSocket = gbSocket;
    }

    /**
     * 将对旧接口的调用适配到新接口
     */
    @Override
    public void powerWithTwoRound() {
        gbSocket.powerWithThreeFlat();
    }
}
