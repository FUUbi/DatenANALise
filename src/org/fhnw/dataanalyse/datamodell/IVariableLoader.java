package org.fhnw.dataanalyse.datamodell;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */
public interface IVariableLoader {
  THEVariableContainer loadVariable(File file);
}
