package org.fhnw.dataanalyse.datamodell;

import java.io.File;

/**
 * Created by Fabrizio on 13.05.2015.
 *
 */
public interface IVariableLoader {
  DataModel loadVariable(File file);
}
