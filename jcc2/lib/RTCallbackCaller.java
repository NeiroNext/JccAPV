package jcc2.lib;

import jcc2.common.JccException;

/**
 *
 * @author note173@gmail.com
 */

public interface RTCallbackCaller
{
    public void $callCallback (Object[] args, int iCallback) throws JccException;
}
