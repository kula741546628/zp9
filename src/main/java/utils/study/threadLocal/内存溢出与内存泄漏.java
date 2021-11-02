package utils.study.threadLocal;

/**
 * @Author kula
 * @create 2021/7/25 下午6:18
 *
 *  1、内存溢出 out of memory，是指程序在申请内存时，没有足够的内存空间供其使用，出现out of memory；
 *  解释：
 *  内存溢出就是你要求分配的内存超出了系统能给你的，系统不能满足需求，于是产生溢出。
 *
 *
 *  2、内存泄露 memory leak，是指程序在申请内存后，无法释放已申请的内存空间，
 *  一次内存泄露危害可以忽略，但内存泄露堆积后果很严重，无论多少内存,迟早会被占光。
 *  memory leak会最终会导致out of memory！
 *  解释：
 *  内存泄漏是指你向系统申请分配内存进行使用(new)，可是使用完了以后却不归还(delete)，
 *  结果你申请到的那块内存你自己也不能再访问（也许你把它的地址给弄丢了），而系统也不能再次将它分配给需要的程序。
 *
 *
 */
public class 内存溢出与内存泄漏 {
}
