/*******************************************************************************
 * Copyright (c) 2015 Thomas Slusny.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package io.nondev.nonlua;

public final class LuaUtils {
    /**
     * When you call a function in lua, it may return a number, and the
     * number will be interpreted as a <code>Double</code>.<br>
     * This function converts the number into a type specified by 
     * <code>retType</code>
     * @param db lua number to be converted
     * @param retType type to convert to
     * @return The converted number
     */
    public static Number convertLuaNumber(Double db, Class retType) {
        if (retType.isPrimitive()) {
            // checks if retType is a primitive type
            if (retType == Integer.TYPE) {
                return new Integer(db.intValue());
            } else if (retType == Float.TYPE) {
                return new Float(db.floatValue());
            } else if (retType == Double.TYPE) {
                return db;
            } else if (retType == Byte.TYPE) {
                return new Byte(db.byteValue());
            } else if (retType == Long.TYPE) {
                return new Long(db.longValue());
            } else if (retType == Short.TYPE) {
                return new Short(db.shortValue());
            }
        } else if (retType.isAssignableFrom(Number.class)) {
            // Checks all possibilities of number types
            if (retType.isAssignableFrom(Integer.class)) {
                return new Integer(db.intValue());
            } else if (retType.isAssignableFrom(Float.class)) {
                return new Float(db.floatValue());
            } else if (retType.isAssignableFrom(Double.class)) {
                return db;
            } else if (retType.isAssignableFrom(Byte.class)) {
                return new Byte(db.byteValue());
            } else if (retType.isAssignableFrom(Long.class)) {
                return new Long(db.longValue());
            } else if (retType.isAssignableFrom(Short.class)) {
                return new Short(db.shortValue());
            }
        }
    
        // if all checks fail, return null
        return null;    
    }
}