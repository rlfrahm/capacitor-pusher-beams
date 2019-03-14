// import { WebPlugin } from '@capacitor/core';
// import { PusherBeamsPlugin } from './definitions';

// export class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
//   constructor() {
//     super({
//       name: 'PusherBeams',
//       platforms: ['web', 'android']
//     });
//   }

//   async echo(options: { value: string }): Promise<{value: string}> {
//     console.log('ECHO', options);
//     return options;
//   }
//   async start(): Promise<{}> {
//     throw new Error("Method not implemented.");
//   }
//   async addDeviceInterest(options: { interest: string; }): Promise<{ success: boolean; }> {
//     return options;
//   }
//   async removeDeviceInterest(options: { interest: string; }): Promise<{ success: boolean; }> {
//     throw new Error("Method not implemented.");
//   }
//   async getDeviceInterests(options: { interests: String[]; }): Promise<{ interestes: String[]; }> {
//     throw new Error("Method not implemented.");
//   }
//   async setDeviceInterests(): Promise<{success: boolean}> {
//     throw new Error("Method not implemented.");
//   }
//   async clearDeviceInterests(): Promise<{ success: boolean; }> {
//     throw new Error("Method not implemented.");
//   }
//   async setOnDeviceInterestsChangedListener(): Promise<{success: boolean}> {
//     throw new Error("Method not implemented.");
//   }
//   async setOnMessageReceivedListenerForVisibleActivity(): Promise<{success: boolean}> {
//     throw new Error("Method not implemented.");
//   }
//   async clearAllState(): Promise<{ success: true; }> {
//     throw new Error("Method not implemented.");
//   }
//   async stop(): Promise<{ success: true; }> {
//     throw new Error("Method not implemented.");
//   }

//   async setUserID(options: { beamsAuthURL: string, userID: string }): Promise<{ beamsAuthURL: string, userID: string }> {
//     return options;
//   }
// }

// const PusherBeams = new PusherBeamsWeb();

// export { PusherBeams };
