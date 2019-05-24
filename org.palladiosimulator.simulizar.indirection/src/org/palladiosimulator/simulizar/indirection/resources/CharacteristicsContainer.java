package org.palladiosimulator.simulizar.indirection.resources;

import java.io.Serializable;
import java.util.Stack;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStack;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;

public class CharacteristicsContainer extends SimulatedStack<Object> {
    private static final long serialVersionUID = 9084890512611014317L;

    private CharacteristicsContainer(SimulatedStack<Object> stack) {
        stack.rootFrame().addValue(CHARACTERISTIC_KEY, this);
    }

    public static CharacteristicsContainer getOrCreate(SimulatedStack<Object> stack) {
        try {
            return (CharacteristicsContainer) stack.rootFrame().getValue(CHARACTERISTIC_KEY);
        } catch (ValueNotInFrameException e) {
            return new CharacteristicsContainer(stack);
        }
    }

    public final static String CHARACTERISTIC_KEY = "__CHARACTERISTICS__";
    
    
    /**
     * Use a Java Stack internally
     */
    Stack<SimulatedStackframe<Object>> stack = new Stack<SimulatedStackframe<Object>>();

    /**
     * Add a stackframe to this stack. The frame has no parent frame.
     *
     * @return The frame added by this method
     */
    public SimulatedStackframe<Object> createAndPushNewStackFrame() {
        final SimulatedStackframe<Object> frame = new SimulatedStackframe<Object>();
        stack.push(frame);
        return frame;
    }

    /**
     * Add a stackframe to this stack using the given frame as parent frame
     *
     * @param parent
     *            The parent frame of the frame to create
     * @return The newly created frame
     */
    public SimulatedStackframe<T> createAndPushNewStackFrame(final SimulatedStackframe<T> parent) {
        final SimulatedStackframe<T> frame = new SimulatedStackframe<T>(parent);
        stack.push(frame);
        return frame;
    }

    /**
     * @return Topmost stackframe on this stack
     */
    public SimulatedStackframe<T> currentStackFrame() {
        return stack.peek();
    }

    /**
     * Pop the topmost stackframe. Called when exiting a scope
     */
    public void removeStackFrame() {
        stack.pop();
    }

    /**
     * @return Size of the stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * Add a stackframe on top of this stack. The frame already exists.
     *
     * @param copyFrame
     *            The frame to push on the stack
     */
    public void pushStackFrame(final SimulatedStackframe<T> copyFrame) {
        stack.push(copyFrame);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SimulatedStack [stack=" + stack + "]";
    }
    
    
    // DW-CET
    public SimulatedStackframe<T> rootFrame() {
        return stack.firstElement();
    }
}
