package game.blob.action;

import game.blob.actor.Blob;

public abstract class BlobAction {
	Blob blob;
	public BlobAction(Blob b){
		blob = b;
	}
	public abstract void doAction();

}
