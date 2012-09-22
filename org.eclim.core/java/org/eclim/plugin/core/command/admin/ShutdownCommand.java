/**
 * Copyright (C) 2005 - 2011  Eric Van Dewoestine
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.eclim.plugin.core.command.admin;

import org.eclim.annotation.Command;

import org.eclim.command.CommandLine;

import org.eclim.eclipse.AbstractEclimApplication;

import org.eclim.logging.Logger;

import org.eclim.plugin.core.command.AbstractCommand;

/**
 * Command to shutdown the eclim server.
 *
 * @author Eric Van Dewoestine
 */
@Command(name = "shutdown")
public class ShutdownCommand
  extends AbstractCommand
{
  private static final Logger logger = Logger.getLogger(ShutdownCommand.class);

  @Override
  public Object execute(CommandLine commandLine)
    throws Exception
  {
    try{
      AbstractEclimApplication app = AbstractEclimApplication.getInstance();
      if (app != null){
        app.stop();
      }
    }catch(Exception e){
      logger.error("Error shutting down eclim:", e);
    }
    return null;
  }
}
