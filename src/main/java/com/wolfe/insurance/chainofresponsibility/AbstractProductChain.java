package com.wolfe.insurance.chainofresponsibility;

/**
 * @author Wilbur
 * @classname AbstractProductChain
 * @description 抽象 产品发布流程 使用责任链模式实现
 *              责任链由多个节点（处理器）组成。在行为模式中有两种：一种是遍历链条上的节点，直到找到对应节点，然后处理为止。
 *              第二种是由各个节点依次处理，共享负担责任的一部分。
 *              本功能采用责任链模式的第二种
 * @date 2020/9/7
 * @since 1.0.0
 */
public abstract class AbstractProductChain {
    public static int CreateInsuranceChain = 1;/**创建险种责任*/
    public static int ReleaseOnlineChain = 2;/**产品发布上线*/
    public static int ProductReviewChain = 3;/**审核*/
    public static int ProductShelvesChain = 4;/**上架*/

    protected int level;
    protected ProductBean productBean;

    //责任链中的下一个元素
    protected AbstractProductChain nextProductChain;

    public void setNextProductChain(AbstractProductChain nextProductChain){
        this.nextProductChain = nextProductChain;
    }

    public void logMessage(int level){
        if(this.level <= level){
            write(productBean);
        }
        if(nextProductChain !=null){
            nextProductChain.logMessage(level);
        }
    }

    abstract protected void write(ProductBean productBean);

}
