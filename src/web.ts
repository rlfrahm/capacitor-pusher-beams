import { WebPlugin } from '@capacitor/core';
import { PusherBeamsPlugin } from './definitions';

export class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
  constructor() {
    super({
      name: 'PusherBeams',
      platforms: ['web']
    });
  }

  async echo(options: { value: string }): Promise<{value: string}> {
    console.log('ECHO', options);
    return options;
  }
  async start(): Promise<{}> {
    throw new Error("Method not implemented.");
  }
  async addDeviceInterest(options: { interest: string; }): Promise<{ success: boolean; }> {
    console.log('addDeviceInterest', options);
    return Promise.resolve({success: true});
  }
  async removeDeviceInterest(options: { interest: string; }): Promise<{ success: boolean; }> {
    console.log('removeDeviceInterest', options);
    return Promise.resolve({ success: true });
  }
  async getDeviceInterests(options: { interests: String[]; }): Promise<{ interests: String[]; }> {
    return Promise.resolve({interests: options.interests});
  }
  async setDeviceInterests(): Promise<{success: boolean}> {
    throw new Error("setDeviceInterest method not implemented.");
  }
  async clearDeviceInterests(): Promise<{ success: boolean; }> {
    return Promise.resolve({success: true});
  }
  async setOnDeviceInterestsChangedListener(): Promise<{success: boolean}> {
    throw new Error("setOnDeviceInterestsChangedListener method not implemented.");
  }
  async setOnMessageReceivedListenerForVisibleActivity(): Promise<{success: boolean}> {
    throw new Error("setOnMessageReceivedListenerForVisibleActivity method not implemented.");
  }
  async clearAllState(): Promise<{ success: boolean; }> {
    return Promise.resolve({success: true});
  }
  async stop(): Promise<{ success: boolean; }> {
    return Promise.resolve({ success: true });
  }

  async setUserID(options: { beamsAuthURL: string, userID: string }): Promise<{ success: boolean, message: string }> {
    console.log('setUserID', options);
    return Promise.resolve({success: true, message: 'success'});
  }
}

const PusherBeams = new PusherBeamsWeb();

export { PusherBeams };
