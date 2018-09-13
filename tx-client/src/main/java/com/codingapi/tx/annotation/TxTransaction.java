package com.codingapi.tx.annotation;

import java.lang.annotation.*;

/**
 * Created by lorne on 2017/6/26.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TxTransaction {


    /**
     * 是否LCN事务发起方
     * @return true 是:是发起方 false 否:是参与方
     */
    boolean isStart() default false;


    /**
     * 回滚异常
     * @return  回滚异常
     */
    Class<? extends Throwable>[] rollbackFor() default {};


    /**
     * 不回滚异常
     * @return 不回滚异常
     */
    Class<? extends Throwable>[] noRollbackFor() default {};

    /**
     * 事务模式 仅在事务发起方配置有效
     * @return 事务模式 仅在事务发起方配置有效
     */
    TxTransactionMode mode() default TxTransactionMode.TX_MODE_LCN;

    boolean readOnly() default false;
}
