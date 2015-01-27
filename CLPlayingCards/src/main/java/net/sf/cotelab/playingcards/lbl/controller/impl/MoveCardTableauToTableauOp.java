package net.sf.cotelab.playingcards.lbl.controller.impl;

import net.sf.cotelab.playingcards.lbl.model.facade.GameSummary;
import net.sf.cotelab.playingcards.util.UndoableOp;

public class MoveCardTableauToTableauOp implements UndoableOp {
	protected ControllerImpl controller;
	protected int destFanIndex;
	protected int srcFanIndex;

	public MoveCardTableauToTableauOp(
			ControllerImpl controller, int srcFanIndex, int destFanIndex) {
		super();
		
		this.controller = controller;
		this.destFanIndex = destFanIndex;
		this.srcFanIndex = srcFanIndex;
	}

	@Override
	public void doOp() {
		controller.moveTopCardTableauToTableau(srcFanIndex, destFanIndex);
		
		controller.updateGameSummary();
	}

	@Override
	public void undoOp() {
		controller.moveTopCardTableauToTableau(destFanIndex, srcFanIndex);

		controller.getModel().getGameSummary().set(GameSummary.IN_PROGRESS);
	}

}
